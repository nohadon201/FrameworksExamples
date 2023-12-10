using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.ComponentModel.DataAnnotations.Schema;  //import per les anotacions
using System.ComponentModel.DataAnnotations;

namespace EFTest1
{
    [Table("Professor")]  //si la taula es diu com la classe no cal
    public class Professor
    {
        //Formula autonumerada    NomdelaclasseID
        public int ProfessorID { get; set; }  //assumeix per el nom que es la ID i que es autonumerada. 
        [Required]
        public string nom { get; set; }
        [Required]
        public string cognom { get; set; }
        [Column("hores_assignades")] //nom
        public int horesAssignades { get; set; }
        //relacio n a n, inferida per el sistema
        public virtual ICollection<Modul> Moduls { get; set; } //per a inferir ha de ser el nom de l'altra classe amb s al final


        //constructor. Les coses les podem afegir per el constructor dinamic de C#
        public Professor()
        {
            this.Moduls = new HashSet<Modul>();
            this.horesAssignades = 0;
        }
    }
}
