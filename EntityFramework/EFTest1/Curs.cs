using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.ComponentModel.DataAnnotations.Schema;  //import per les anotacions
using System.ComponentModel.DataAnnotations;


namespace EFTest1
{
    public class Curs
    {
        public int CursID { get; set; }  //assumeix per el nom que es la ID
        public bool actiu { get; set; }
        [Required]  //fa que no pugui ser null
        public int any { get; set; }
        //enum
        public CicleFormatiu cicle { get; set; }
        //relacio 1 a n, inferida per el sistema
        public ICollection<Modul> Modul { get; set; }
        //relacio 1 a 1, feta amb anotacions
        [Column("Tutor"),ForeignKey("Professor")]  ///Clau Foranea
        public int ProfessorID { get; set; }
        //Objecte virtual per a fer la navegació
        public virtual Professor Professor { get; set; }



    }


    public enum CicleFormatiu
    {
        DAM,
        ASIX,
        DAMVI
    }
}
