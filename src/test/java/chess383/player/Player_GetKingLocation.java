/*
 *  Player_GetKingLocation.java
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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.exception.NoKingDefinedException;
import chess383.piece.abstraction.Piece;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;

/**
 * <p>
 * The class Player_GetKingLocation implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public method Piece getKingLocation( ) for class Player is tested")
public class Player_GetKingLocation {  
    
    @Test
    @DisplayName("getKingLocation(): returns the location for the black player where the king is placed")
    public void getKingLocation_ReturnsTheLocationOfTheBlackKing() {
        
        final ColorEnum COLOR = ColorEnum.BLACK;
        final String KING_POSITION = "f6";
        final String QUEEN_POSITION = "g7";
        
        assertThat( KING_POSITION )
                  .as( String.format( "the created player has placed the king on location %s.", KING_POSITION ) )
                  .isEqualTo( Player.create( COLOR, Arrays.asList( MovedKing.create( KING_POSITION ), Queen.create( QUEEN_POSITION ) ) ).getKingLocation() );
    }
    
    @Test
    @DisplayName("getKingLocation(): returns the location for the white player where the king is placed")
    public void getKingLocation_ReturnsTheLocationOfTheWhiteKing() {
        
        final ColorEnum COLOR = ColorEnum.WHITE;
        final String KING_POSITION = "e1";
        final String QUEEN_POSITION = "g7";
        
        assertThat( KING_POSITION )
                  .as( String.format( "the created player has placed the king on location %s.", KING_POSITION ) )
                  .isEqualTo( Player.create( COLOR, Arrays.asList( MovedKing.create( KING_POSITION ), Queen.create( QUEEN_POSITION ) ) ).getKingLocation() );
    }
    
    @Test
    @DisplayName("getKingLocation(): throws an exception if the list of pieces is empty")
    public void getKingLocation_ThrowsExceptionOnEmptyList() {
        
        final ColorEnum COLOR = ColorEnum.BLACK;
        
        Player player = Player.create( COLOR, new ArrayList<Piece>() );
        assertThatThrownBy(() -> { player.getKingLocation(); })
                .isExactlyInstanceOf( NoKingDefinedException.class );
    }
    
    @Test
    @DisplayName("getKingLocation(): throws an exception if the list of pieces doesn not contain a king")
    public void getKingLocation_ThrowsExceptionOnListWithoutKing() {
        
        final ColorEnum COLOR = ColorEnum.WHITE;
        final String ROOK_POSITION = "f6";
        final String QUEEN_POSITION = "g7";
        
        Player player = Player.create( COLOR, Arrays.asList( Rook.create( ROOK_POSITION ), Queen.create( QUEEN_POSITION ) ) );
        assertThatThrownBy(() -> { player.getKingLocation(); })
                .isExactlyInstanceOf( NoKingDefinedException.class );
    }
}


