// Prints out an ascii glass. Size is determined by integer cmd input
// By Omera Ezike
// 4/17/2018

using System;
namespace TestStuff
{
    class PrintGlass
    {

        static void Main(string[] args)
        {
            const int DEFAULT_SIZE = 4;
            int glassSize = 4;
            String input;

            if (args.Length == 1)
            {
                input = args[0];
            }

            else
            {
                Console.Write("Enter glass size: ");
                input = Console.ReadLine();
                Console.WriteLine();
            }

            // glass Size is 4 if input is not formatted correctly, less than 0, or not present
            if (!Int32.TryParse(input, out glassSize))
            {
                glassSize = DEFAULT_SIZE;
            }

            if (glassSize < 1)
            {
                glassSize = DEFAULT_SIZE;
            }

            // maxWidth gets maximum width of characters used to create the glass
            int maxWidth = getNextOdd(glassSize);

            createBowl(glassSize, maxWidth);
            createStem(glassSize, maxWidth);
            createFoot(maxWidth);
            Console.ReadKey();
        }

        // Creates bowl of glass with zeros.
        public static void createBowl(int glassSize, int maxWidth)
        {
            int buffer = 0;

            for (int i = 0; i < glassSize; i++)
            {
                for (int j = 0; j < buffer; j++)
                {
                    Console.Write(" ");
                }

                for (int k = 0; k < maxWidth; k++)
                {
                    Console.Write("0");
                }

                Console.Write("\n");
                buffer += 1;
                maxWidth -= 2;
            }
        }

        // Creates stem of glass with verticle line.
        private static void createStem(int glassSize, int maxWidth)
        {
            int buffer = (maxWidth - 1) / 2;

            for (int i = 0; i < glassSize; i++)
            {
                for (int j = 0; j < buffer; j++)
                {
                    Console.Write(" ");
                }
                Console.Write("|\n");
            }
        }

        // Creates foot of glass with equals sign.
        private static void createFoot(int maxWidth)
        {
            for (int i = 0; i < maxWidth; i++)
            {
                Console.Write("=");
            }
        }

        // Returns the nth consecutive odd integer
        private static int getNextOdd(int num)
        {
            int oddNum = 1;

            // For when the glass is less than size 1
            if (num < 1)
            {
                return 0;
            }

            for (int i = 1; i < num; i++)
            {
                oddNum += 2;
            }
            return oddNum;
        }
    }
}