/*
 *  Player_Remove.java
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

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.queen.Queen;

/**
 * <p>
 * The class Player_Remove implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public method Player remove( ) for class Player is tested")
public class Player_Remove {  
    
    @Test
    @DisplayName("remove(): a piece for black player is removed")
    public void remove_APieceForBlackPlayerIsRemoved_ThenThereIsNoPieceOnTheLocation() {
        
        final ColorEnum COLOR = ColorEnum.BLACK;
        final String KING_POSITION = "f6";
        final String QUEEN_POSITION = "g7";
        
        Player player = Player.create( COLOR, Arrays.asList( MovedKing.create( KING_POSITION ), Queen.create( QUEEN_POSITION ) ) );
        assertThatThrownBy(() -> { player.remove( QUEEN_POSITION ).getPiece( QUEEN_POSITION ).getLocation(); })
                .isExactlyInstanceOf( NullPointerException.class );
    }
    
    @Test
    @DisplayName("remove(): a piece for white player is removed")
    public void remove_APieceForWhitePlayerIsRemoved_ThenThereIsNoPieceOnTheLocation() {
        
        final ColorEnum COLOR = ColorEnum.WHITE;
        final String KING_POSITION = "e2";
        final String QUEEN_POSITION = "g7";
        
        Player player = Player.create( COLOR, Arrays.asList( MovedKing.create( KING_POSITION ), Queen.create( QUEEN_POSITION ) ) );
        assertThatThrownBy(() -> { player.remove( QUEEN_POSITION ).getPiece( QUEEN_POSITION ).getLocation(); })
                .isExactlyInstanceOf( NullPointerException.class );
    }
    
    @Test
    @DisplayName("remove(): an empty location for white player should be removed")
    public void remove_AnEmptyLocationShouldBeRemoved() {
        
        final ColorEnum COLOR = ColorEnum.WHITE;
        final String EMPTY_LOCATION = "b2";
        final String KING_POSITION = "e2";
        final String QUEEN_POSITION = "g7";
        
        Player player = Player.create( COLOR, Arrays.asList( MovedKing.create( KING_POSITION ), Queen.create( QUEEN_POSITION ) ) );
        assertThat( player.remove( EMPTY_LOCATION ) )
                  .as( "if remove() is called for an empty location nothing is removed" )
                  .isEqualTo( player );
    }
}


