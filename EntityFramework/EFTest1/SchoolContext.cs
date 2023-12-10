using System.Data.Entity;

namespace EFTest1
{
    public class SchoolContext : DbContext
    {
        public SchoolContext() : base("IES")
        {



        }

        public DbSet<Student> Students { get; set; }
        public DbSet<Grade> Grades { get; set; }



    }
}
