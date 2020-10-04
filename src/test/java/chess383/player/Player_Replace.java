/*
 *  Player_Replace.java
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

/**
 * <p>
 * The class Player_Replace implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   June 2020
 *
 */
@DisplayName("the public method Player replace( ) for class Player is tested")
public class Player_Replace {  
    
    @Test
    @DisplayName("replace(): a piece for black player is replaced and then the new location can be retrieved")
    public void replace_APieceForBlackPlayerIsReplaced_TheTheNewLocationCanBeRetrieved() {
        
        final ColorEnum COLOR = ColorEnum.BLACK;
        final String ORIGIN_KING_POSITION = "f6";
        final String TARGET_KING_POSITION = "g7";
        final String QUEEN_POSITION = "g7";
        
        Player player = Player.create( COLOR, Arrays.asList( MovedKing.create( ORIGIN_KING_POSITION ), Queen.create( QUEEN_POSITION ) ) );
        assertThat( player.replace( ORIGIN_KING_POSITION, TARGET_KING_POSITION ).getPiece( TARGET_KING_POSITION ).getLocation( ) )
                  .as( "the replaced piece provides the new location" )
                  .isEqualTo( TARGET_KING_POSITION );
    }
}


