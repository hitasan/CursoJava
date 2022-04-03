 package secao16;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import secao16.chess.ChessException;
import secao16.chess.ChessMatch;
import secao16.chess.ChessPiece;
import secao16.chess.ChessPosition;

public class Chess {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();		// Instanciando a partida de xadrez
		List<ChessPiece> captured = new ArrayList<>();
		
		while (!chessMatch.getCheckMate()) {
			try {

				UI.clearScreen();								// realiza a limpeza da tela a cada passada
				UI.printMatch(chessMatch, captured);		 	// imprimindo na tela a partida e pegando as peças da classe chessmatch
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				if ( capturedPiece != null ) {
					captured.add(capturedPiece);
				}
				
				if ( chessMatch.promoted() != null ) {
					System.out.print("Enter piece for promotion [B/N/R/Q]: ");
					String type = sc.nextLine().toUpperCase();
					while ( !type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q") ) {
						System.out.print("Invalid value! Enter piece for promotion [B/N/R/Q]: ");
						type = sc.nextLine().toUpperCase();
					}

					chessMatch.replacePromotedPiece(type);
				}

			} catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.hasNextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.hasNextLine();
			}
		}

		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}

}
