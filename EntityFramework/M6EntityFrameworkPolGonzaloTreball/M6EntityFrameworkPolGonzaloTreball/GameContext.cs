using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace M6EntityFrameworkPolGonzaloTreball
{
    public class GameContext : DbContext
    {
        public GameContext() : base("Tokio")
        {

        }

        public DbSet<Monstre> Monstres { get; set; }
        public DbSet<Partida> Partides { get; set; }
        public DbSet<Jugador> Jugadors { get; set; }
        /**
         *                START 
         */
        ///<summary> <c>Start</c> This function starts with all initial information of the bbdd and set the information of the Players and game too.</summary> 
        public void Start()
        {


            Monstre m1 = new Monstre()
            {
                NomMonstre = "M1",
                Eliminat = false,
                Energia = 0,
                Jugable = true,
                NumeroPuntsDeVictoria = 0,
                Tokio = true,
                NumeroVides = 10,
                MonstrePoderAsociat = null
            };
            Monstre m2 = new Monstre()
            {
                NomMonstre = "M2",
                Eliminat = false,
                Energia = 0,
                Jugable = true,
                NumeroPuntsDeVictoria = 0,
                Tokio = false,
                NumeroVides = 10,
                MonstrePoderAsociat = null
            };
            Monstre m3 = new Monstre()
            {
                NomMonstre = "M3",
                Eliminat = false,
                Energia = 0,
                Jugable = true,
                NumeroPuntsDeVictoria = 0,
                Tokio = false,
                NumeroVides = 10,
                MonstrePoderAsociat = null
            };
            Monstre m4 = new Monstre()
            {
                NomMonstre = "M3",
                Eliminat = false,
                Energia = 0,
                Jugable = true,
                NumeroPuntsDeVictoria = 0,
                Tokio = false,
                NumeroVides = 10,
                MonstrePoderAsociat = null
            };
            Monstre MonstrePoder1 = new Monstre()
            {
                Jugable = false,
                CostCartaPoder = 0,
                IdCartaPoder = CartesPoder.AlientoFlamigero
            };
            Monstre MonstrePoder2 = new Monstre()
            {
                Jugable = false,
                CostCartaPoder = 6,
                IdCartaPoder = CartesPoder.RayoReductor
            };
            Monstre MonstrePoder3 = new Monstre()
            {
                Jugable = false,
                CostCartaPoder = 4,
                IdCartaPoder = CartesPoder.EscupidorDeVeneno
            };
            Monstre MonstrePoder4 = new Monstre()
            {
                Jugable = false,
                CostCartaPoder = 8,
                IdCartaPoder = CartesPoder.Mimetismo
            };
            this.Monstres.Add(m1);
            this.Monstres.Add(m2);
            this.Monstres.Add(m3);
            this.Monstres.Add(MonstrePoder1);
            this.Monstres.Add(MonstrePoder2);
            this.Monstres.Add(MonstrePoder3);
            this.Monstres.Add(MonstrePoder4);
            this.SaveChanges();
            Console.WriteLine("The monster M1 is put in Tokio only for test de EsATokio function.");
            Console.WriteLine("All monsters added correctly.");
            Console.WriteLine();
            Console.WriteLine("Starting with the players...");
            Players();

        }
        /// <summary>
        /// <c>Players</c> This function set all players information
        /// </summary>
        public void Players()
        {
            bool fi = false;
            int contador = 0;
            while (!fi)
            {
                Console.WriteLine("Escriu el teu nom: ");
                String Nom = Console.ReadLine();
                Console.WriteLine("Escriu el teu cognom: ");
                String Cognom = Console.ReadLine();
                Jugador j = new Jugador() { NomJugador = Nom, CognomJugador = Cognom };
                int a = 0;
                List<Monstre> monstresLliures = new List<Monstre>();
                foreach (Monstre m in this.Monstres)
                {

                    if (m.IdJugador == null && m.Jugable)
                    {
                        a++;
                        Console.WriteLine("El monstre " + m.NomMonstre + " està lliure. Pulsa " + a + " per a seleccionarlo.");
                        monstresLliures.Add(m);
                    }
                }
                while (j.monstres.Count == 0)
                {
                    Console.WriteLine("Pulsa Algún dels nombres mencionats abans.");
                    int ey = Int32.Parse(Console.ReadLine());
                    if (ey > 0 || ey <= monstresLliures.Count)
                    {
                        j.monstres.Add(monstresLliures[ey - 1]);
                    }
                }
                this.Jugadors.Add(j);
                this.SaveChanges();
                Console.WriteLine("Saved Player " + j.NomJugador);
                contador++;
                if (contador == 4)
                {
                    fi = true;
                }
                else if (contador >= 2)
                {
                    Console.WriteLine("Tens Jugados suficients, vols comenzar partida? [1 Sí / 0 No]");
                    int eleccio = Int32.Parse(Console.ReadLine());
                    if (eleccio == 0)
                    {
                        fi = true;
                    }
                }
            }
            Partida();
        }
        /// <summary>
        /// <c>Partida</c> This function set the game information
        /// </summary>
        public void Partida()
        {
            Partida p = new Partida() { NomJugadorAsociats = this.Jugadors.Count() };
            foreach (Monstre m in this.Monstres)
            {
                if (m.IdPartida == null && m.Jugable)
                {
                    p.monstresPartida.Add(m);
                }
            }
            this.Partides.Add(p);
            this.SaveChanges();


        }

        /**
         *                TIRAR DAUS  
         */
        ///<summary>
        ///<c>TirarDaus</c> This function return a list of random values of type enum <seealso cref="ResultatDau"/>.
        ///<returns>The list of random values</returns></summary>
        public List<ResultatDau> TirarDaus()
        {
            Random r = new Random();
            List<ResultatDau> dausValues = new List<ResultatDau>();
            for (int i = 0; i < 6; i++)
            {
                Array values = Enum.GetValues(typeof(ResultatDau));
                Random random = new Random();
                ResultatDau resultat_random = (ResultatDau)values.GetValue(random.Next(values.Length));
                dausValues.Add(resultat_random);
            }
            foreach (ResultatDau daus in dausValues)
            {
                Console.WriteLine("Has tret: " + daus.ToString());
            }
            return dausValues;
        }
        /// <summary>
        /// This function solves the random values returned by the TirarDaus() Function. <seealso cref="TirarDaus"/>
        /// </summary>
        /// <param name="IdMonstre">The id for change the monster</param>
        public void SolveRoll(int IdMonstre)
        {
            List<ResultatDau> resultats = TirarDaus();
            Dictionary<ResultatDau, int> repeticions = new Dictionary<ResultatDau, int>();
            foreach (ResultatDau daus in resultats)
            {
                switch (daus)
                {
                    case ResultatDau.UN:
                    case ResultatDau.DOS:
                    case ResultatDau.TRES:
                        int a = 0;
                        if (repeticions.TryGetValue(daus,out a))
                        {
                            repeticions[daus]=a+1;
                        }
                        else
                        {
                            repeticions.Add(daus, 1);
                        }
                        
                        break;
                    case ResultatDau.COR:
                        this.Monstres.Find(IdMonstre).NumeroVides++;
                        break;
                    case ResultatDau.ENERGÍA:
                        this.Monstres.Find(IdMonstre).Energia++;
                        break;
                    case ResultatDau.ATAC:
                        break;
                }
            }
            foreach (KeyValuePair<ResultatDau, int> i in repeticions)
            {
                if (i.Value >= 3)
                {
                    switch (i.Key)
                    {
                        case ResultatDau.UN:
                            this.Monstres.Find(IdMonstre).NumeroPuntsDeVictoria++;
                            this.Monstres.Find(IdMonstre).NumeroPuntsDeVictoria += i.Value - 3;
                            break;
                        case ResultatDau.DOS:
                            this.Monstres.Find(IdMonstre).NumeroPuntsDeVictoria+=2;
                            this.Monstres.Find(IdMonstre).NumeroPuntsDeVictoria += i.Value - 3;
                            break;
                        case ResultatDau.TRES:
                            this.Monstres.Find(IdMonstre).NumeroPuntsDeVictoria+=3;
                            this.Monstres.Find(IdMonstre).NumeroPuntsDeVictoria += i.Value - 3;
                            break;
                    }
                }
            }
            Console.WriteLine("Fi de programa");
            Console.ReadLine();
            this.SaveChanges();
        }
        /// <summary>
        /// This function is used in case that we need a list of Power Monsters.
        /// </summary>
        /// <returns>A list of Monsters that doesn't have any player.</returns>
        public List<Monstre> llistarCartesMonstresLliure()
        {
            List<Monstre> returning = new List<Monstre>();
            foreach (Monstre monstre in Monstres)
            {

                if (!monstre.Jugable && monstre.MonstreJugableAsociat == null)
                {
                    returning.Add(monstre);
                }

            }
            return returning;
        }
        /// <summary>
        /// 
        /// </summary>
        /// <returns>The Monster that is in Tokio in case that is one in it. In other case will return null value.</returns>
        public Monstre GetMonstreTokio()
        {
            foreach(Monstre m in this.Monstres) { 
                if(m.Tokio && !m.Eliminat && m.Jugable)
                {
                    return m;
                }
            }
            return null;
        }
        /// <summary>
        /// This function is used when a player must choose one contrincant player
        /// </summary>
        /// <param name="IdMonstre">The player monster id that choose</param>
        /// <returns>A list of Monsters that are contrincants</returns>
        public List<Monstre> GetContrincants(int IdMonstre)
        {
           return this.Monstres.Where(a => a.MonstreID!=IdMonstre).ToList();
        }
        /// <summary>
        /// This functions allows to shop the PowerCarts.
        /// </summary>
        /// <param name="IdMonstreJugable">The id of monster that is shoping</param>
        public void ComprarCartesPoder(int IdMonstreJugable)
        {
            List<Monstre> arr = this.llistarCartesMonstresLliure();
            int indCosesQuePotComprar = 0;
            foreach (Monstre monstre in arr)
            {
                if (this.Monstres.Find(IdMonstreJugable).Energia >= monstre.CostCartaPoder)
                {
                    indCosesQuePotComprar++;
                    Console.WriteLine();
                    Console.WriteLine(
                    "Pots Comprar: " + monstre.IdCartaPoder + " cost: " + monstre.CostCartaPoder);
                    Console.WriteLine("Pulsa " + monstre.MonstreID + " si vols comprarlo");
                    Console.WriteLine();
                }
            }
            Console.WriteLine("Per sortir de la botiga pulsa 0");
            bool fi = indCosesQuePotComprar == 0;
            while (!fi)
            {
                int IdMonstre = Int32.Parse(Console.ReadLine());    
                if(IdMonstre>0 && IdMonstre <= this.Monstres.Count())
                {
                    if(!this.Monstres.Find(IdMonstre).Jugable && this.Monstres.Find(IdMonstre).MonstreJugableAsociat == null)
                    {
                        this.Monstres.Find(IdMonstreJugable).MonstrePoderAsociat = this.Monstres.Find(IdMonstre);
                        this.Monstres.Find(IdMonstre).MonstreJugableAsociat = this.Monstres.Find(IdMonstreJugable);
                        fi= true;
                    }
                }
                
            }
            this.SaveChanges();
        }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            //Database.SetInitializer(new CreateDatabaseIfNotExists<GameContext>()); //update, pero crea la DB!
            //Database.SetInitializer(new DropCreateDatabaseIfModelChanges<GameContext>());  //aquest seria un metode update pero si canvies el model (els POCOS) reinicia la DB
            Database.SetInitializer(new DropCreateDatabaseAlways<GameContext>());  //equivaldria a un create

            modelBuilder.Entity<Monstre>().HasOptional(x => x.MonstreJugableAsociat).WithOptionalPrincipal(a => a.MonstrePoderAsociat);
            base.OnModelCreating(modelBuilder);


        }

    }
}
