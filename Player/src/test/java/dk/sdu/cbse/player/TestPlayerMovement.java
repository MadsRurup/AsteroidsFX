package dk.sdu.cbse.player;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.GameInput;
import dk.sdu.cbse.common.World;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class TestPlayerMovement {
    @Test
    public void testPlayerMovedForward() {
        PlayerProcessor processor = new PlayerProcessor();
        Player player = new Player();
        player.setX(1);
        player.setY(0);
        player.setRotation(0);
        GameInput input = mock(GameInput.class);
        when(input.getKeyNumber("W")).thenReturn(87);
        when(input.isPressed(87)).thenReturn(true);
        System.out.println(input.isPressed(32));
        System.out.println(input.isPressed(87));

        GameData mockGameData = mock(GameData.class);
        when(mockGameData.getGameInput()).thenReturn(input);
        System.out.println(input.isPressed(input.getKeyNumber("W")));
        World mockWorld = mock(World.class);
        System.out.println(player.getX());
        when(mockGameData.getHeight()).thenReturn(600);
        when(mockGameData.getWidth()).thenReturn(800);
        when(mockWorld.getEntities(Player.class)).thenReturn(List.of(player));
        mockWorld.addEntity(player);
        processor.process(mockGameData,mockWorld);
        List<Entity> entities = mockWorld.getEntities(Player.class);
        System.out.println(entities.get(0) == player);

        assertTrue((player.getX() != 0 || player.getY() != 0));
    }


}
