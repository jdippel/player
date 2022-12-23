/*
 *  Player_GetPieceTypeLocations.java
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
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.ColorEnum;
import chess383.ICoordinate;
import chess383.ICoordinateFactory;
import chess383.piece.abstraction.Piece;
import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.InitialWhitePawn;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;

/**
 * <p>
 * The class Player_GetPieceTypeLocations implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public method List<String> getPieceTypeLocations() for class Player is tested")
public class Player_GetPieceTypeLocations {    

    final String ORIGIN = "e5";
    static final ICoordinate board = ICoordinateFactory.STANDARD.get( );
    
    @ParameterizedTest( name = "given a list of pieces and a selector {0} the the locations of the filtered pieces should be returned" )
    @MethodSource("fenAndListAndListProvider")
    public void testWithMultiArgMethodSource_mappingAGivenPieveTypeForAGivenListOfPieces_ThenTheListOfLocationsOfTheSubsetIsReturned( char fen, List<Piece> pieces, List<String> locations ) {
        
        ColorEnum color = ( Character.isUpperCase( fen )) ? ColorEnum.WHITE : ColorEnum.BLACK;
    
        Player player = Player.create( color, pieces );
        List<String> originLocations = player.getPieceTypeLocations( Character.toLowerCase( fen ));
        
        assertThat( locations.size() ).as( "list of pieces should match size" ).isEqualTo( originLocations.size() );
        for( String location : locations ) {
            assertThat( originLocations.contains( location ) ).as( "everey location must be included" ).isTrue();
        }
    }
 
    
    public static Stream<Arguments> fenAndListAndListProvider() {
        return Stream.of(
            
            Arguments.of( 'K', Arrays.asList( MovedKing.create( "e2" ), Queen.create( "d1" ) ), List.of( "e2" ))
          , Arguments.of( 'n', Arrays.asList(
                    InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                    Knight.create( "b8" ), Knight.create( "g8" ), Bishop.create( "c8" ), Bishop.create( "f8" ),
                    InitialWhitePawn.create( "a7" ), InitialWhitePawn.create( "b7" ), InitialWhitePawn.create( "c7" ), InitialWhitePawn.create( "d7" ),
                    InitialWhitePawn.create( "e7" ), InitialWhitePawn.create( "f7" ), InitialWhitePawn.create( "g7" ), InitialWhitePawn.create( "h7" )), 
                    Arrays.asList( "b8", "g8" ))
            
        ); }
}


