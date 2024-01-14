using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PolGonzalo_Examen_M6_UF2
{
    public class ExamenContext : DbContext
    {
        public ExamenContext() : base("Examen")
        {

        }
        public DbSet<Immoble> Immoble { get; set; }
        public void getImmoble(bool nou)
        {
            List<Immoble> resultat = new List<Immoble>();
            foreach (Immoble immoble in Immoble)
            {
                Console.WriteLine(immoble.Nou);
                if (nou)
                {
                    if (immoble.Nou)
                    {
                        resultat.Add(immoble);
                    }
                    else if (immoble.edifici != null)
                    {
                        resultat.Add((immoble));    
                    }
                }
                else
                {
                    if (immoble.tipus == Tipus.Edifici)
                    {
                        foreach (Immoble im in immoble.immoble)
                        {
                            resultat.Add(im);
                        }
                    }
                    else
                    {
                        resultat.Add(immoble);
                    }
                }
            }
            foreach (Immoble immoble in resultat)
            {

                Console.WriteLine("NomFiscal: " + immoble.NomFiscal + ", Adreça: " + immoble.Adreça + ", Preu: " + immoble.PreuLloguer + ", Nou: " + immoble.Nou);
            }
            Console.ReadLine();
        }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            Database.SetInitializer(new CreateDatabaseIfNotExists<ExamenContext>()); //update, pero crea la DB!
            //Database.SetInitializer(new DropCreateDatabaseIfModelChanges<ExamenContext>());  //aquest seria un metode update pero si canvies el model (els POCOS) reinicia la DB
            //Database.SetInitializer(new DropCreateDatabaseAlways<ExamenContext>());  //equivaldria a un create

            /*modelBuilder.Entity<Modul>()
            .HasRequired<Curs>(m => m.Curs)
            .WithMany(c => c.Modul)
            .HasForeignKey<int>(m => m.elSeuCurs)
            .WillCascadeOnDelete(false);
            */
            //modelBuilder.Entity<Monstre>().HasOptional(x => x.MonstreJugableAsociat).WithOptionalPrincipal(a => a.MonstrePoderAsociat);
            //modelBuilder.Entity<Immoble>().HasOptional(x => x.MobleID).WithRequired(a=> a.)
            base.OnModelCreating(modelBuilder);


        }
    }
}
