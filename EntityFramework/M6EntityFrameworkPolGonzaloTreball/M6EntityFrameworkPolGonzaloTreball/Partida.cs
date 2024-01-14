using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace M6EntityFrameworkPolGonzaloTreball
{
    public class Partida
    {
        public int PartidaID { get; set; }
        public int Torn { get; set; }
        [Range(2,4)] public int NomJugadorAsociats { get; set; }

        /**
         *            RELACIONS 
         */

        public ICollection<Monstre> monstresPartida { get; set; }

        public Partida()
        {
            monstresPartida=new List<Monstre>();    
        }
    }
}
