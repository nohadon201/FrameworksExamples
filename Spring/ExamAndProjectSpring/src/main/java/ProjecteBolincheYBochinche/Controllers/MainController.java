package ProjecteBolincheYBochinche.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ProjecteBolincheYBochinche.Services.JugadorService;
import ProjecteBolincheYBochinche.Services.MonstreService;
import ProjecteBolincheYBochinche.Services.PartidaService;
import ProvaSpring2.Model.Juego;
import ProvaSpring2.Model.Jugador;
import ProvaSpring2.Services.JuegoServices;
import ProvaSpring2.Services.JugadorServices;

@Controller
public class MainController {
	@Autowired
	JugadorService jugadorService;
	
	@Autowired
	PartidaService partidaService;
	
	@Autowired
	MonstreService monstreService;
	
	@Autowired
	JuegoServices juegoServices;

	@Autowired
	JugadorServices jugadorServices;

	@GetMapping(path = "/") // Map ONLY GET Requests
	public @ResponseBody String welcome() {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		return "Estoy vivito y coleando!!!";
	}

	@GetMapping(path = "/addJuego")
	public @ResponseBody String addJuego(@RequestParam String name, @RequestParam int edad, @RequestParam int precio) {

		Juego j = new Juego();
		j.setNombre(name);
		j.setEdad(edad);
		j.setPrecio(precio);

		juegoServices.insertar(j);

		return "Guardado!!!";

	}

	@GetMapping(path = "/allJuegos")
	public @ResponseBody List<Juego> allJuegos() {
		return juegoServices.findAll();
	}

	@GetMapping(path = "/Juego/{id}")
	public @ResponseBody Juego getJuego(@PathVariable int id) {
		Juego j = juegoServices.findById(id);
		return j;
	}

	@GetMapping(path = "/juegoDelete/{id}")
	public @ResponseBody String deleteJuego(@PathVariable Integer id) {
		juegoServices.delete(id);
		return "Borrat";
	}

	@GetMapping(path = "/allJugadores")
	public @ResponseBody List<Jugador> getAlljugadores() {
		// This returns a JSON or XML with the users
		return jugadorServices.findAll();
	}

	@GetMapping(path = "/jugador/{id}")
	public @ResponseBody Jugador getJugador(@PathVariable int id) {
		Jugador j = jugadorServices.findById(id);
		return j;
	}

	@GetMapping(path = "/jugadorDelete/{id}")
	public @ResponseBody String deleteJugador(@PathVariable Integer id) {
		jugadorServices.delete(id);
		return "Borrat";
	}

	@GetMapping(path = "/Jugador/add") // Map ONLY GET Requests
	public @ResponseBody String addJugador(@RequestParam String name, @RequestParam String apellidos,
			@RequestParam int saldo) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Jugador j = new Jugador();
		j.setNombre(name);
		j.setApellidos(apellidos);
		j.setSaldo(saldo);
		jugadorServices.insertar(j);
		return "Saved";
	}

	@GetMapping(path = "/Jugador/Juego")
	public @ResponseBody String addJugadorJuego(@RequestParam int idJugador, @RequestParam int idJuego) {

		Jugador jugador = jugadorServices.findById(idJugador);
		Juego juego = juegoServices.findById(idJuego);
		jugador.getJuegos().add(juego);
		jugadorServices.editar(jugador);
		return "Guardado!!!";
	}

	@GetMapping(path = "/Jugador/Apellidos")
	public @ResponseBody List<Jugador> getJugadoresApellidos(@RequestParam String apes) {
		return jugadorServices.findByApellidosIgnoreCase(apes);
	}

	@GetMapping(path = "/Jugador/ApellidosAscNombre")
	public @ResponseBody List<Jugador> getJugadoresApellidosAscNombre(@RequestParam String apes) {
		return jugadorServices.findByApellidosOrderByNombreAsc(apes);
	}

	@GetMapping(path = "/Jugador/ApellidosDescNombre")
	public @ResponseBody List<Jugador> getJugadoresApellidosDescNombre(@RequestParam String apes) {
		return jugadorServices.findByApellidosOrderByNombreDesc(apes);
	}

	@GetMapping(path = "/Jugador/adinerados")
	public @ResponseBody List<Jugador> GetAdinerados(@RequestParam int saldo) {
		return jugadorServices.jugadorEntacao(saldo);
	}

	@GetMapping(path = "/Jugador/adinerados2/{saldo}")
	public @ResponseBody List<Jugador> GetAdinerados2(@PathVariable int saldo) {
		return jugadorServices.jugadorEntacao(saldo);
	}

	@GetMapping(path = "/Jugador/adinerados3/{saldo}")
	public @ResponseBody List<Jugador> GetAdinerados3(@PathVariable int saldo) {
		return jugadorServices.jugadorEntacao2(saldo);
	}

	@GetMapping(path="/Jugador/adinerados4")
	public @ResponseBody List<Jugador> GetAdinerados4(@RequestParam (name="q", required = false) String saldo){
		List<Jugador> result = (saldo==null)? jugadorServices.findAll() : jugadorServices.jugadorEntacao(Integer.parseInt(saldo));
		
		return result;
	}
}