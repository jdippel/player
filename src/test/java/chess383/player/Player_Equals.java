/*
 *  Player_Equals.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 Jörg Dippel
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package chess383.player;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;

/**
 * <p>
 * The class Player_Equals implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public method boolean equals( ) for class Player is tested")
public class Player_Equals {  
    
    @Test
    @DisplayName("equals(): the order of definitions is not relevant for the result of equals()")
    public void equals_WhenOrderIsDifferent() {
        
        final ColorEnum COLOR = ColorEnum.BLACK;
        final String KING_POSITION = "f6";
        final String QUEEN_POSITION = "g7";
        
        assertThat( Player.create( COLOR, Arrays.asList( MovedKing.create( KING_POSITION ), Queen.create( QUEEN_POSITION ) )).equals( Player.create( COLOR, Arrays.asList( Queen.create( QUEEN_POSITION ), MovedKing.create( KING_POSITION ) ))))
                  .as( "the created player is equal to a play with another order of pieces" )
                  .isTrue();
    }
    
    @SuppressWarnings("unlikely-arg-type")
	@Test
    @DisplayName("equals(): returns false for another object instance")
    public void equals_WhenNotAPlayer() {
        
        final ColorEnum COLOR = ColorEnum.BLACK;
        final String KING_POSITION = "f6";
        final String QUEEN_POSITION = "g7";
        
        assertThat( Player.create( COLOR, Arrays.asList( MovedKing.create( KING_POSITION ), Queen.create( QUEEN_POSITION ) )).equals( "Hello" ) )
                  .as( "the created player is not equal to another object instance" )
                  .isFalse();
    }
    
    @Test
    @DisplayName("equals(): the definitions are not equal")
    public void equals_WhenPieceListsAreDifferent() {
        
        final ColorEnum COLOR = ColorEnum.BLACK;
        final String KING_POSITION = "f6";
        final String QUEEN_POSITION = "g7";
        
        assertThat( Player.create( COLOR, Arrays.asList( MovedKing.create( KING_POSITION ), Queen.create( QUEEN_POSITION ) )).equals( Player.create( COLOR, Arrays.asList( Rook.create( QUEEN_POSITION ), MovedKing.create( KING_POSITION ) ))))
                  .as( String.format( "the created player are not equal because on %s the are different piece types located", QUEEN_POSITION ) )
                  .isFalse();
    }
    
    @Test
    @DisplayName("equals(): the order of definitions is not relevant for the result of equals() but the color")
    public void equals_WhenOrderIsDifferentAnadAlsoTheColor() {
        
        final String KING_POSITION = "f6";
        final String QUEEN_POSITION = "g7";
        
        assertThat( Player.create( ColorEnum.WHITE, Arrays.asList( MovedKing.create( KING_POSITION ), Queen.create( QUEEN_POSITION ) )).equals( Player.create( ColorEnum.BLACK, Arrays.asList( Queen.create( QUEEN_POSITION ), MovedKing.create( KING_POSITION ) ))))
                  .as( "the created player is equal to a play with another order of pieces" )
                  .isFalse();
    }
}


