package co.cubestudio.arrays.fibonacci2048;

class Mover {
    private final FibonacciSeriesLookUpTable table;

    Mover() {
        this.table = new FibonacciSeriesLookUpTable();
    }

    private boolean canCombine(int a, int b) {
        if (a == 0 || b == 0) {
            return false;
        }
        if (a == 1 && b == 1) {
            return true;
        }
        return table.areInSequence(a, b) || table.areInSequence(b, a);
    }

    private int[] processLine(int[] inputLine) {
        int n = inputLine.length;
        int[] nonZero = new int[n];
        int nz = 0;
        for (int v : inputLine) if (v != 0) nonZero[nz++] = v;

        int[] outputLine = new int[n];
        int write = 0;
        int i = 0;
        while (i < nz) {
            if (i + 1 < nz && canCombine(nonZero[i], nonZero[i + 1])) {
                outputLine[write++] = nonZero[i] + nonZero[i + 1];
                i += 2;
            } else {
                outputLine[write++] = nonZero[i++];
            }
        }
        while (write < n) outputLine[write++] = 0;
        return outputLine;
    }

    private int[] extract(The2048Bonacci game, int index, Direction dir) {
        int w = game.getWidth();
        int h = game.getHeight();
        switch (dir) {
            case LEFT: {
                int[] line = new int[w];
                for (int x = 0; x < w; x++) {
                    line[x] = game.getTile(x, index);
                }
                return line;
            }
            case RIGHT: {
                int[] line = new int[w];
                for (int x = 0; x < w; x++) {
                    line[x] = game.getTile(w - 1 - x, index);
                }
                return line;
            }
            case UP: {
                int[] line = new int[h];
                for (int y = 0; y < h; y++) {
                    line[y] = game.getTile(index, y);
                }
                return line;
            }
            case DOWN: {
                int[] line = new int[h];
                for (int y = 0; y < h; y++) {
                    line[y] = game.getTile(index, h - 1 - y);
                }
                return line;
            }
            default:
                return new int[0];
        }
    }

    private void write(The2048Bonacci game, int index, Direction dir, int[] line) {
        int w = game.getWidth();
        int h = game.getHeight();
        switch (dir) {
            case LEFT: {
                for (int x = 0; x < w; x++) {
                    game.setTile(x, index, line[x]);
                }
                break;
            }
            case RIGHT: {
                for (int x = 0; x < w; x++) {
                    game.setTile(w - 1 - x, index, line[x]);
                }
                break;
            }
            case UP: {
                for (int y = 0; y < h; y++) {
                    game.setTile(index, y, line[y]);
                }
                break;
            }
            case DOWN: {
                for (int y = 0; y < h; y++) {
                    game.setTile(index, h - 1 - y, line[y]);
                }
                break;
            }
        }
    }

    public void playStep(The2048Bonacci game, Direction push) {
        if (push == Direction.LEFT || push == Direction.RIGHT) {
            for (int y = 0; y < game.getHeight(); y++) {
                int[] line = extract(game, y, push);
                int[] processed = processLine(line);
                write(game, y, push, processed);
            }
        } else {
            for (int x = 0; x < game.getWidth(); x++) {
                int[] line = extract(game, x, push);
                int[] processed = processLine(line);
                write(game, x, push, processed);
            }
        }
    }
}
