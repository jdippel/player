/*
 *  Player_Promote.java
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
import chess383.piece.abstraction.PieceFactory;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.pawn.MovedBlackPawn;
import chess383.piece.concretion.queen.Queen;

/**
 * <p>
 * The class Player_Promote implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
@DisplayName("the public method Player promote( ) for class Player is tested")
public class Player_Promote {  
    
    @Test
    @DisplayName("promote(): the black player pawn is promoted to a rook")
    public void promote_WhenTheBlackPawnIsPromoteToARook_TheTheTypeWillBeTheTypeOfARook() {
        
        final ColorEnum COLOR = ColorEnum.BLACK;
        final String KING_LOCATION = "f6";
        final String LOCATION = "c1";

        Player player = Player.create( COLOR, Arrays.asList( MovedKing.create( KING_LOCATION ), MovedBlackPawn.create( LOCATION ) ) );
        
        assertThat( player.promote( PieceFactory.createPiece( LOCATION, 'r' ), LOCATION ).getPiece( LOCATION ).isRook() )
                  .as( "the cloned player holds after promotion a rook" )
                  .isTrue();
    }
    
    @Test
    @DisplayName("promote(): if no promotion piece is provided for white player nothing is done")
    public void promote_WhenNoPieceISPassedNothingIsDone() {
        
        final ColorEnum COLOR = ColorEnum.WHITE;
        final String QUEEN_LOCATION = "b2";
        final String KING_LOCATION = "e2";
        final String EMPTY_LOCATION = "b8";
        
        Player player = Player.create( COLOR, Arrays.asList( MovedKing.create( KING_LOCATION ), Queen.create( QUEEN_LOCATION ) ) );
        assertThat( player.promote( null, EMPTY_LOCATION ) )
                  .as( "if promote() is called for an empty location nothing is promoted" )
                  .isEqualTo( player );
    }
}


