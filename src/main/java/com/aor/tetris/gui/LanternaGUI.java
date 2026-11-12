package com.aor.tetris.gui;


import com.aor.tetris.model.Position;
import com.aor.tetris.model.game.StopWatch;
import com.aor.tetris.model.game.Board;
import com.aor.tetris.model.game.Piece;
import com.aor.tetris.model.game.PieceRandomGenerator;
import com.aor.tetris.model.game.Stats;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class LanternaGUI implements GUI{
    private final Screen screen;

    public LanternaGUI(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        return terminalFactory.createTerminal();
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws FontFormatException, IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        assert resource != null;
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 27);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void drawSquare(Position position, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), " ");
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Character && Character.toLowerCase(keyStroke.getCharacter()) == 'z') return ACTION.Z;

        if (keyStroke.getKeyType() == KeyType.Character && Character.toLowerCase(keyStroke.getCharacter()) == ' ') return ACTION.SPACE;


        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void clear() {
        screen.clear();
    }



    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }




    @Override
    public void drawPiece(Piece piece){
        if (piece != null) {
            for (Position position : piece.getActualPositions(piece.getCentralPosition(), piece.getDirection())) {
                drawSquare(new Position(position.getX() + 1, 1 + position.getY()), piece.getColor());
            }
        }
    }

    @Override
    public void drawPieceShadow(Piece piece){
        if (piece != null) {
            for (Position position : piece.getActualPositions(piece.getCentralPosition(), piece.getDirection())) {
                drawSquare(new Position(position.getX() + 1, 1 + position.getY()), "#555555");
            }
        }
    }

    @Override
    public void drawPieceRandomGenerator(PieceRandomGenerator pieceRandomGenerator){
        for(int i = 17; i <= 22; i++) {
            for(int j = 10; j <= 19; j++) {
                drawSquare(new Position(i, j), "#666666");
            }
        }

        int count = 0;
        for(int i = 11; i <= 17; i += 3) {
            for(int j = 18 ;j <= 21; j++ ) {
                drawSquare(new Position(j, i), "#4B4B4B");
                drawSquare(new Position(j, i+1), "#4B4B4B");
            }
            drawPiecePos(pieceRandomGenerator.getPieceRandomGenerator().get(count++), new Position(20,  i + 1));


        }
    }

    @Override
    public void drawBoard(Board board){
        for(int y = 0; y < board.getBoard().length; y++){
            for(int x = 0; x < board.getBoard()[0].length; x++){
                if (board.getBoard()[y][x] != null)
                    drawSquare(new Position(x+1,1+y), board.getBoard()[y][x].getColor());
            }
        }
    }

    @Override
    public void drawStopWatch(StopWatch stopWatch) {
        drawText(new Position(14, 2), "T", "#C1D4E3");
        drawText(new Position(15, 2), "I", "#F3C6A6");
        drawText(new Position(16, 2), "M", "#FCF1C0");
        drawText(new Position(17, 2), "E", "#CCE8DB");
        drawText(new Position(18, 2), "R", "#FF9AA2");
        drawText(new Position(22, 2), String.format("%04d", stopWatch.getElapsedTime()), "#FFFFFF");
    }


    private void drawPiecePos(Piece piece, Position CentralPos){
        if (piece != null) {
            for (Position position : piece.getPositions(piece.getDirection())) {
                drawSquare(new Position(position.getX() + CentralPos.getX(), position.getY() + CentralPos.getY()), piece.getColor());
            }
        }
    }
    @Override
    public void drawStats(Stats stats) {
        drawText(new Position(14, 1), "S", "#C1D4E3");
        drawText(new Position(15, 1), "C", "#F3C6A6");
        drawText(new Position(16, 1), "O", "#FCF1C0");
        drawText(new Position(17, 1), "R", "#CCE8DB");
        drawText(new Position(18, 1), "E", "#FF9AA2");



        drawText(new Position(22, 1), String.format("%04d", stats.getScore()), "#FFFFFF");

        drawText(new Position(14, 5), "LEVEL", "#FF5062");
        drawText(new Position(22, 5), String.format("%01d", stats.getLevel()), "#FFFFFF");

        drawText(new Position(14, 7), "LINES", "#FF5062");
        drawText(new Position(22, 7), String.format("%02d", stats.getLines()), "#FFFFFF");
    }
}