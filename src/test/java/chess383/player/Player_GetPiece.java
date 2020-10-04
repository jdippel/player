/*
 *  Player_GetPiece.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2019, 2020 Jörg Dippel
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

/**
 * <p>
 * The class Player_GetPiece implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   June 2020
 *
 */
@DisplayName("the public method Piece getPiece( ) for class Player is tested")
public class Player_GetPiece {  
    
    @Test
    @DisplayName("getPiece(): if a piece is located on a given location the piece is returned")
    public void getPiece_ForAGivenLocation_ThenTheRelatedPieceIsReturned() {
        
        final ColorEnum COLOR = ColorEnum.BLACK;
        final String KING_POSITION = "f6";
        final String QUEEN_POSITION = "g7";
        
        assertThat( Player.create( COLOR, Arrays.asList( MovedKing.create( KING_POSITION ), Queen.create( QUEEN_POSITION ) ) ).getPiece( KING_POSITION ) )
                  .as( "the created player holds the information about defined king" )
                  .isInstanceOf( MovedKing.class );
    }
}


