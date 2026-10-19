package com.example.structural.facade;

/**
 * ONE simple button for a complicated system.
 *
 * To watch a movie you must switch on 3 devices in the right order.
 * The facade does it for you: you only call watchMovie("Matrix").
 *
 * STUDENT TASK 4 - write the two methods.
 */
public class HomeTheaterFacade {

    private final Projector projector;
    private final SoundSystem sound;
    private final StreamingPlayer player;

    public HomeTheaterFacade(Projector projector, SoundSystem sound, StreamingPlayer player) {
        this.projector = projector;
        this.sound = sound;
        this.player = player;
    }

    public void watchMovie(String movie) {
        // TODO: do these 4 steps, in this order:
        //   1. projector.on()
        //   2. sound.on()
        //   3. sound.setVolume(10)
        //   4. player.play(movie)
        projector.on();
        sound.on();
        sound.setVolume(10);
        player.play(movie);
    }

    public void endMovie() {
        // TODO: do these 3 steps, in this order (the opposite of watchMovie):
        //   1. player.stop()
        //   2. sound.off()
        //   3. projector.off()
        player.stop();
        sound.off();
        projector.off();
    }
}
