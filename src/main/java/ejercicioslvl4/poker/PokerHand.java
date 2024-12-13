/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioslvl4.poker;

/**
 *
 * @author tarde
 */
public class PokerHand
{      
    public enum Result { TIE, WIN, LOSS } 

    PokerHand(String hand)      
    {
        
    }

    public Result compareWith(PokerHand hand) {        
        return Result.TIE;
    }
}

