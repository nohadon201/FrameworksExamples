using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.ComponentModel.DataAnnotations.Schema;  //import per les anotacions
using System.ComponentModel.DataAnnotations;
using System.Data.SqlTypes;

namespace EFTest1
{
    public class Modul
    {


        [Key] //Clau primaria
        public int Codi { get; set; } 
        [Required]
        public string nom { get; set; }
        [Column("hores_setmana")] //nom
        public int horesSetmana { get; set; }
        public SqlDateTime dataInici { get; set; }
        //relacio 1 a n, inferida per el sistema
        public Curs Curs { get; set; }

        //public int elSeuCurs { get; set; }
        //relacio n a n, inferida per el sistema
        public virtual ICollection<Professor> Professors { get; set; } //per a inferir ha de ser el nom de l'altra classe amb s al final


        //constructor. Les coses les podem afegir per el constructor dinamic de C#
        public Modul()
        {
            this.Professors = new HashSet<Professor>();
            this.dataInici = new SqlDateTime(DateTime.Now);
        }

    }
}
