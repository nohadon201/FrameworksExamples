using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PolGonzalo_Examen_M6_UF2
{
    public class Program
    {
        static void Main(string[] args)
        {
            using(var ctx = new ExamenContext())
            {
                //Immoble im = new Immoble() { NomFiscal = "I1", Adreça = "CARR1", Nou = true, PreuLloguer = 150, tipus = Tipus.Edifici };
                //Immoble im2 = new Immoble() { NomFiscal = "I2", Adreça = "CARR2", Nou = false, PreuLloguer = 50, tipus = Tipus.Xalet };
                //Immoble im3 = new Immoble() { NomFiscal = "I3", Adreça = "CARR3", Nou = false, PreuLloguer = 400, tipus = Tipus.Local };
                //Immoble im4 = new Immoble() { NomFiscal = "I4", Adreça = "CARR4", Nou = false, PreuLloguer = 5, tipus = Tipus.Pis };
                //Immoble im5 = new Immoble() { NomFiscal = "I5", Adreça = "CARR5", Nou = true, PreuLloguer = 90, tipus = Tipus.Local };
                //im.immoble.Add(im2);
                //im.immoble.Add(im3);
                //im3.edifici = im;
                //im2.edifici = im;
                //ctx.Immoble.Add(im);
                //ctx.Immoble.Add(im2);
                //ctx.Immoble.Add(im3);
                //ctx.Immoble.Add(im4);
                //ctx.Immoble.Add(im5);
                //ctx.SaveChanges();
                ctx.getImmoble(true);
            }
        }
    }
}
