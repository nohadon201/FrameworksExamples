using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace M6EntityFrameworkPolGonzaloTreball
{
    public class Monstre
    {
        public int MonstreID { get; set; }
        public string NomMonstre { get; set; }
        
        public int NumeroVides { get; set; }
        public int NumeroPuntsDeVictoria { get; set; }
        public int Energia { get; set; }
        public bool Tokio { get; set; }
        public bool Eliminat { get; set; }

        public bool Jugable { get; set; }

        /**
         *                  RELACIONS
         */
        public virtual Monstre MonstrePoderAsociat { get; set; }
        public Jugador IdJugador { get; set; }
        public Partida IdPartida { get; set; }

        /**
         *                Monstre Poder
         */
        public CartesPoder IdCartaPoder { get; set; }   
        public int CostCartaPoder { get; set; }
        public virtual Monstre MonstreJugableAsociat { get; set; }
    }
    public enum CartesPoder
    {
        AlientoFlamigero, Mimetismo, RayoReductor, EscupidorDeVeneno
    }
    public enum ResultatDau
    {
        UN, DOS, TRES, COR, ENERGÍA, ATAC
    }
}
