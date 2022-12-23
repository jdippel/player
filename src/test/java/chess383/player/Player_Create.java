/*
 *  Player_Create.java
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
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.queen.Queen;

/**
 * <p>
 * The class Player_Create implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public static factory method Player create( ) for class Player is tested")
public class Player_Create {  
    
    @Test
    @DisplayName("create(): when white player is created with pieces then the pieces can be found")
    public void create_WhenWhitePlayerIsCreatedWithPieces_ThenThePiecesCanBeFound() {
        
        final ColorEnum COLOR = ColorEnum.WHITE;
        final String INITIAL_KING_POSITION = "e1";
        
        assertThat( Player.create( COLOR, List.of( InitialKing.create(INITIAL_KING_POSITION ) )).getPiece( INITIAL_KING_POSITION ).isKing() )
                  .as( "the created player holds the information about the piece type" )
                  .isTrue();
    }
    
    @Test
    @DisplayName("create(): when black player is created with pieces then the pieces can be found")
    public void create_WhenBlackPlayerIsCreatedWithPieces_ThenThePiecesCanBeFound() {
        
        final ColorEnum COLOR = ColorEnum.BLACK;
        final String KING_POSITION = "f6";
        final String QUEEN_POSITION = "g7";
        
        Player createdPlayer = Player.create( COLOR, Arrays.asList( MovedKing.create( KING_POSITION ), Queen.create( QUEEN_POSITION ) ));
        
        assertThat( createdPlayer.getPiece( KING_POSITION ).isKing() )
                  .as( "the created player holds the information about the defined piece type - king" )
                  .isTrue();
        
        assertThat( createdPlayer.getPiece( QUEEN_POSITION ).isQueen() )
                  .as( "the created player holds the information about the defined piece type - queen" )
                  .isTrue();
    }
    
    @Test
    @DisplayName("createBlackPlayer(): when black player is created then all the pieces are contained")
    public void create_WhenBlackPlayerIsCreated_ThenAllThePiecesAreContained() {
        
        Player createdPlayer = Player.createBlackPlayer();

        assertThat( createdPlayer.getPiece( "e8" ).isKing() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "d8" ).isQueen() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "f8" ).isBishop() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "c8" ).isBishop() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "b8" ).isKnight() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "g8" ).isKnight() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "a8" ).isRook() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "h8" ).isRook() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "a7" ).isBlackPawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "b7" ).isBlackPawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "c7" ).isBlackPawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "d7" ).isBlackPawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "e7" ).isBlackPawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "f7" ).isBlackPawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "g7" ).isBlackPawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "h7" ).isBlackPawn() ).as( "player contains the piece on right location" ).isTrue(); 
    }
    
    @Test
    @DisplayName("createWhitePlayer(): when white player is created then all the pieces are contained")
    public void create_WhenWhitePlayerIsCreated_ThenAllThePiecesAreContained() {
        
        Player createdPlayer = Player.createWhitePlayer();

        assertThat( createdPlayer.getPiece( "e1" ).isKing() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "d1" ).isQueen() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "f1" ).isBishop() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "c1" ).isBishop() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "b1" ).isKnight() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "g1" ).isKnight() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "a1" ).isRook() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "h1" ).isRook() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "a2" ).isWhitePawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "b2" ).isWhitePawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "c2" ).isWhitePawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "d2" ).isWhitePawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "e2" ).isWhitePawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "f2" ).isWhitePawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "g2" ).isWhitePawn() ).as( "player contains the piece on right location" ).isTrue();
        assertThat( createdPlayer.getPiece( "h2" ).isWhitePawn() ).as( "player contains the piece on right location" ).isTrue(); 
    }
}


