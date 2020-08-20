package ru.job4j.chess.firuges.black;

import static org.hamcrest.CoreMatchers.is;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {
    @Test
    public void whenCreate() {
        Cell position = Cell.C2;
        BishopBlack figure = new BishopBlack(position);
        Assert.assertThat(figure.position(), is(position));
    }

    @Test
    public void whenCopyThenRightPosition() {
        BishopBlack figure = new BishopBlack(Cell.C1);
        Cell position = Cell.D2;
        Figure copiedFigure = figure.copy(position);
        Assert.assertThat(copiedFigure.position(), is(position));
    }

    @Test
    public void whenWayD4A7ThenC5B6A7() throws ImpossibleMoveException {
        BishopBlack figure = new BishopBlack(Cell.D4);
        Cell[] expectedWay = {Cell.C5, Cell.B6, Cell.A7};
        Cell[] way = figure.way(Cell.A7);
        Assert.assertThat(way, is(expectedWay));
    }

    @Test
    public void whenWayD4F6ThenE5F6() throws ImpossibleMoveException {
        BishopBlack figure = new BishopBlack(Cell.D4);
        Cell[] expectedWay = {Cell.E5, Cell.F6};
        Cell[] way = figure.way(Cell.F6);
        Assert.assertThat(way, is(expectedWay));
    }

    @Test
    public void whenWayD4B2ThenC3B2() throws ImpossibleMoveException {
        BishopBlack figure = new BishopBlack(Cell.D4);
        Cell[] expectedWay = {Cell.C3, Cell.B2};
        Cell[] way = figure.way(Cell.B2);
        Assert.assertThat(way, is(expectedWay));
    }

    @Test
    public void whenWayD4E3ThenE3() throws ImpossibleMoveException {
        BishopBlack figure = new BishopBlack(Cell.D4);
        Cell[] expectedWay = {Cell.E3};
        Cell[] way = figure.way(Cell.E3);
        Assert.assertThat(way, is(expectedWay));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNoDiagonalThenException()throws ImpossibleMoveException {
        BishopBlack figure = new BishopBlack(Cell.D4);
        Cell[] way = figure.way(Cell.D2);
    }

}