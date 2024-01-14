using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PolGonzalo_Examen_M6_UF2
{
    public class Immoble
    {
        public int ImmobleID { get; set; }
        [MaxLength(50)]
        public String NomFiscal { get; set; }
        [MaxLength(100)]
        public String Adreça { get; set; }
        public Tipus tipus { get; set; }
        public int PreuLloguer { get; set; }
        public bool Nou { get; set; }
        public ICollection<Immoble> immoble { get; set; }
        public Immoble edifici { get; set; }
        
        public Immoble() {
            immoble = new HashSet<Immoble>();
        }
    }
    public enum Tipus
    {
        Edifici, Pis, Local, Xalet
    }
}
