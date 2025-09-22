package org.JavaChallenges;

public class countChar
{
    public static void main(String[] args)
    {
        String str ="programming";
        char target = 'm';
        int count = 0;

        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == target)
            {
                count++;
            }
        }
        System.out.println("Character " + target + " appeared " + count + " times");
    }
}


