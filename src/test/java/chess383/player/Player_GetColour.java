/*
 *  Player_GetColour.java
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
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.piece.concretion.king.InitialKing;

/**
 * <p>
 * The class Player_GetColour implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public method ColorEnum getColour( ) for class Player is tested")
public class Player_GetColour {  
    
    @Test
    @DisplayName("getColour(): when white player is created then the colour matches")
    public void create_WhenWhitePlayerIsCreated_ThenTheColourMatches() {
        
        final ColorEnum COLOR = ColorEnum.WHITE;
        final String INITIAL_KING_POSITION = "e1";
        
        assertThat( Player.create( COLOR, List.of( InitialKing.create(INITIAL_KING_POSITION ) )).getColour() )
                  .as( "the created player holds the information about colour" )
                  .isEqualTo( COLOR );
    }
    
    @Test
    @DisplayName("getColour(): when black player is created then the colour matches")
    public void create_WhenBlackPlayerIsCreated_ThenTheColourMatches() {
        
        final ColorEnum COLOR = ColorEnum.BLACK;
        
        assertThat( Player.createBlackPlayer().getColour() )
                  .as( "the created player holds the information about colour" )
                  .isEqualTo( COLOR );
    }
}


