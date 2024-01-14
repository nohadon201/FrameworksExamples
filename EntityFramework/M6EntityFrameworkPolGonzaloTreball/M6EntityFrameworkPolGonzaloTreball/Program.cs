using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Runtime.ConstrainedExecution;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace M6EntityFrameworkPolGonzaloTreball
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Jugador j = new Jugador() { NomJugador = "Antonio", CognomJugador = "Paco" };
            using (var ctx = new GameContext())
            {
                ctx.Start();
                ctx.SolveRoll(1);
                ctx.ComprarCartesPoder(1);
                Console.WriteLine("The monster "+ctx.GetMonstreTokio().NomMonstre+" is currently in Tokio.");
                foreach(Monstre m in ctx.GetContrincants(1))
                {
                    Console.WriteLine("El monstre " + ctx.Monstres.Find(1).NomMonstre + " es contrincant de " + m.NomMonstre);
                }
            }
        }
    }
}
