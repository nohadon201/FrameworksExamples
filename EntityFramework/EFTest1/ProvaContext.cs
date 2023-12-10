using System.Data.Entity;

namespace EFTest1
{
    public class ProvaContext : DbContext
    {
        //Crea el context. Crea una DB per defecte (es a dir, MS SQL Server, amb nom "Test")
        public ProvaContext() : base("Test")
        {

        }

        //Mapeig als POCOS.
        public DbSet<Professor> Professor { get; set; }
        public DbSet<Modul> Modul { get; set; }
        public DbSet<Curs> Curs { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            //Database.SetInitializer(new CreateDatabaseIfNotExists); //update, pero crea la DB!
            //Database.SetInitializer(new DropCreateDatabaseIfModelChanges<ProvaContext>());  //aquest seria un metode update pero si canvies el model (els POCOS) reinicia la DB
            Database.SetInitializer(new DropCreateDatabaseAlways<ProvaContext>());  //equivaldria a un create

            /*modelBuilder.Entity<Modul>()
            .HasRequired<Curs>(m => m.Curs)
            .WithMany(c => c.Modul)
            .HasForeignKey<int>(m => m.elSeuCurs)
            .WillCascadeOnDelete(false);
            */


            base.OnModelCreating(modelBuilder);


        }

    }
}
