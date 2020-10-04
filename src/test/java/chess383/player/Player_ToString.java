/*
 *  Player_ToString.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2019 Jörg Dippel
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
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.queen.Queen;

/**
 * <p>
 * The class Player_ToString implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2019
 *
 */
@DisplayName("the public method String toString( ) for class Player is tested")
public class Player_ToString {  
    
    @Test
    @DisplayName("toString(): when white player is created then the toString() description contains the piece description")
    public void ToString_InitialWhiteKingPosition() {
        
        final String INITIAL_KING_POSITION = "e1";
        final String EXPECTED_DESCRIPTION = String.format( "%s%n( %s, initial king )%n", ColorEnum.WHITE, INITIAL_KING_POSITION );
        
        Player player = Player.create( ColorEnum.WHITE, Arrays.asList( InitialKing.create( INITIAL_KING_POSITION ) ) );
        
        assertThat( player.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( EXPECTED_DESCRIPTION );
    }
    
    @Test
    @DisplayName("toString(): when black player with arbitrary position is created hen the toString() description contains the piece description")
    public void ToString_ArbitraryBlackPosition() {
        
        final ColorEnum COLOR = ColorEnum.BLACK;
        final String KING_POSITION = "f6";
        final String QUEEN_POSITION = "g7";
        final String EXPECTED_DESCRIPTION = String.format( "%s%n", COLOR ) +
                String.format( "( %s, initial king )%n", KING_POSITION ) +
                String.format( "( %s, queen )%n", QUEEN_POSITION );
        
        Player player = Player.create( COLOR, Arrays.asList( InitialKing.create( KING_POSITION ), Queen.create( QUEEN_POSITION ) ) );
        
        assertThat( player.toString() )
                  .as( "the string representation should match" )
                  .isEqualTo( EXPECTED_DESCRIPTION );
    }
}


