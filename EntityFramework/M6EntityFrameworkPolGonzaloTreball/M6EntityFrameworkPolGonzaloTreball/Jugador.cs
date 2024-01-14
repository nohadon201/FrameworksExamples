using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace M6EntityFrameworkPolGonzaloTreball
{
    public class Jugador
    {
        public Jugador() {
            this.monstres = new List<Monstre>();
        }
        
        public int JugadorID { get; set; }
        public string NomJugador { get; set; }
        public string CognomJugador { get; set; }
        
        /**
         *            RELACIONS 
        */
        
        public ICollection<Monstre> monstres { get; set; }


    }
}
