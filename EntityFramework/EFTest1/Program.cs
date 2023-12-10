using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EFTest1
{
    class Program
    {
        static void Main(string[] args)
        {
            /*
            using (var ctx = new SchoolContext())
            {
                var stud = new Student() { StudentName = "Jaume" };

                ctx.Students.Add(stud);
                ctx.SaveChanges();
            }
            */
            using (var ctx = new ProvaContext())
            {
                var marc = new Professor() { nom = "Marc", cognom = "Albareda" };
                var grego = new Professor() { nom = "Gregorio", cognom = "Santamaria" };
                var m6 = new Modul() { Codi = 6, nom = "Acces a Dades", horesSetmana = 4 };

                marc.Moduls.Add(m6);

                ctx.Modul.Add(m6);
                ctx.Professor.Add(marc);
                ctx.Professor.Add(grego);
                Console.WriteLine(marc.Moduls);
                ctx.SaveChanges();
                Console.WriteLine("Todo Ha salido a pedir de Milhouse");

                List<Professor> listg = ctx.Professor.ToList();

                
                foreach(Professor p in listg)
                {
                    
                    Console.WriteLine(p.cognom);
                    if (p.nom == "Marc")
                    {
                        Console.WriteLine("guapo");
                    }
                }


                //contar
                Console.WriteLine(   ctx.Professor.Count());


                //select
                Professor test1 = ctx.Professor
                                    .Where(p => p.cognom == "Albareda")
                                    .FirstOrDefault();
                Console.WriteLine( test1.cognom);

                //find per clau primeria
                Professor test2 = ctx.Professor.Find(2);
                Console.WriteLine(test2.cognom);

                Console.ReadLine();


                //update
                test1.nom = "GregMarc";
                //no cal "guardar l'update", EF ho assumeix auto
                ctx.SaveChanges();



                //all
                bool flag = ctx.Professor.All(p => p.nom.StartsWith("G"));
                Console.WriteLine(flag);

                //delete
                ctx.Professor.Remove(test2);
                ctx.SaveChanges();



            }
        }
    }

}
