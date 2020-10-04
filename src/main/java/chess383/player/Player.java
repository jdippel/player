/*
 *  Player.java
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import chess383.ColorEnum;
import chess383.exception.NoKingDefinedException;
import chess383.piece.abstraction.Piece;
import chess383.piece.concretion.bishop.Bishop;
import chess383.piece.concretion.king.InitialKing;
import chess383.piece.concretion.king.MovedKing;
import chess383.piece.concretion.knight.Knight;
import chess383.piece.concretion.pawn.InitialBlackPawn;
import chess383.piece.concretion.pawn.InitialWhitePawn;
import chess383.piece.concretion.queen.Queen;
import chess383.piece.concretion.rook.Rook;

/**
 * Provides a chess player.
 *
 * @author    Jörg Dippel
 * @version   September 2020
 *
 */
public class Player {
    
    /** ---------  Attributes  -------------------------------- */
    
    private Map<String, Piece> player;
    private ColorEnum colour;
    
    /** ---------  Getter and Setter  ------------------------- */

    private void setPlayer()                       { this.player = new HashMap<>(); }
    private Map<String, Piece> getPlayer()         { return this.player; }
    private void setColour( ColorEnum value )      { this.colour = value; }
    public  ColorEnum getColour()                  { return this.colour; }

    /** ---------  Constructors  ------------------------------ */
    
    private Player( ColorEnum colour ) {
        
        setColour(colour);
        setPlayer();
    }
 
    /** ---------  Factory  ----------------------------------- */
    
    public static Player create( ColorEnum colour, List<Piece> pieces ) {
        
        Player result = new Player( colour );
        for( Piece piece : pieces ) {
            result.getPlayer().put( piece.getLocation(), piece );
        }
        return( result );
    }
    
    public static Player createWhitePlayer() {
        
        return create( ColorEnum.WHITE, Arrays.asList( 
                InitialKing.create( "e1" ), Queen.create( "d1" ), Rook.create( "a1" ), Rook.create( "h1" ),
                Knight.create( "b1" ), Knight.create( "g1" ), Bishop.create( "c1" ), Bishop.create( "f1" ),
                InitialWhitePawn.create( "a2" ), InitialWhitePawn.create( "b2" ), InitialWhitePawn.create( "c2" ), InitialWhitePawn.create( "d2" ),
                InitialWhitePawn.create( "e2" ), InitialWhitePawn.create( "f2" ), InitialWhitePawn.create( "g2" ), InitialWhitePawn.create( "h2" )  ));
    }
    
    public static Player createBlackPlayer() {
    
        return create( ColorEnum.BLACK, Arrays.asList( 
                InitialKing.create( "e8" ), Queen.create( "d8" ), Rook.create( "a8" ), Rook.create( "h8" ),
                Knight.create( "b8" ), Knight.create( "g8" ), Bishop.create( "c8" ), Bishop.create( "f8" ),
                InitialBlackPawn.create( "a7" ), InitialBlackPawn.create( "b7" ), InitialBlackPawn.create( "c7" ), InitialBlackPawn.create( "d7" ),
                InitialBlackPawn.create( "e7" ), InitialBlackPawn.create( "f7" ), InitialBlackPawn.create( "g7" ), InitialBlackPawn.create( "h7" ) ));
    }
    
    /** ------------------------------------------------------- */
    
    public Player clone() {
    
        return( create( getColour(), getAllPieces() ));
    }
    
    public Piece getPiece( String location ) {
        return getPlayer().get( location );
    }
    
    public List<String> getPieceTypeLocations( char fen ) {
    
        List<String> resultList = new ArrayList<String>();
        Piece piece;
        for( String location : getPlayer().keySet() ) {
            piece = getPiece( location );
            if( piece.getForsythEdwardsNotation() == fen ) resultList.add( location );
        }
        return resultList;
    }
    
    public String getKingLocation() throws NoKingDefinedException {
        
        Piece piece;
        for( String location : getPlayer().keySet() ) {
            piece = getPiece( location );
            if( piece instanceof InitialKing || piece instanceof MovedKing ) return location;
        }
        NoKingDefinedException.throwNoKingDefinedException( "" );
        return "";
    }
    
    private List<Piece> getAllPieces() {
        
        List<Piece> list = new ArrayList<Piece>();
        
        for( String location : getPlayer().keySet()) {
            list.add( getPiece( location ));
        }
        
        return list;
    }
    
    public int getNumberOfPieces() {
        
        return getPlayer().keySet().size();
    }
    
    public Player replace( String origin, String target ) {
        
        Player clone = clone();
        Piece piece = getPlayer().get( origin );
        clone.getPlayer().remove( origin );
        clone.getPlayer().put( target, piece.replace( target ));
        
        return clone;
    }
    
    public Player remove( String location ) {
        
        Piece piece = getPlayer().get( location );
        if( piece != null ) {
            Player clone = clone();
            clone.getPlayer().remove( location );
            return clone;
        }
        
        return this;
    }
    
    public Player promote( Piece piece, String location ) {
        
        if( piece != null ) {
            Player clone = clone();
            clone.getPlayer().remove( location );
            clone.getPlayer().put( location, piece );
            return clone;
        }
        
        return this;
    }
    
    /** ---------  Inheritance from Object  ------------------- */
    
    @Override
    public String toString() {
        
        String description = String.format("%s%n", getColour().toString() );
        Set<String> keySet = getPlayer().keySet();
        SortedSet<String> sortedKeySet = new TreeSet<>();
        for ( String key : keySet ) {
            sortedKeySet.add( key );
        }
        for ( String key : sortedKeySet ) {
            Piece piece = getPlayer().get(key);
            String pieceDescription = piece.toString();
            description = description.concat( String.format("( %s, %s )%n", key, pieceDescription.substring( 0, pieceDescription.indexOf(':'))));

        }
        return description;
    }
    
    @Override
    public boolean equals( Object object ) {
        if( object instanceof Player ) {
            Player player = ( Player )object;
            if( getColour() == player.getColour() && getNumberOfPieces() == player.getNumberOfPieces() ) {
                for( Piece piece : player.getAllPieces() ) {
                    if( piece.equals( getPiece( piece.getLocation() ) )) {
                        // true
                    }
                    else {
                        return false;
                    }
                }
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return getKingLocation().hashCode();
    }
}
