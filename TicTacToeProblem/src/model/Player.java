package model;

public class Player {
    private PlayingPiece playingPiece;
    private String name;

    public Player(PlayingPiece playingPiece, String name) {
        this.playingPiece = playingPiece;
        this.name = name;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playingPiece=" + playingPiece +
                ", name='" + name + '\'' +
                '}';
    }
}
