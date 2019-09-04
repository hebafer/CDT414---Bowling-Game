/**
 * BowlingGame Score calculator
 *
 * @author CDT414 Student:
 * @version 1.0
 * @date 2016-11-24
 */
public class BowlingGame {

	/**
	 * BowlingGame Score calculator constructor which require string as input
	 * 
	 * @param game
	 *            Expected format "[n,n][n,n]..[n,n]"
	 * 
	 */
	private int[] frames;
	private boolean expectedFormat;

	public BowlingGame(String game) {
		// TODO: create constructor for BowlingGame
		if (game == null) {
			this.expectedFormat = false;
		} else {
			this.expectedFormat = this.isCorrect(game);
			if (this.expectedFormat) {
				String[] items = game.replaceAll("\\[", "").replaceAll("\\]", ",").replaceAll("\\s", "").split(",");
				this.frames = new int[items.length];
				for (int i = 0; i < items.length; i++) {
					frames[i] = Integer.parseInt(items[i]);
				}
				this.expectedFormat = lastFrameValid();
			}
		}
	}

	/**
	 * getScore method returns a score of current Bowling game or -1 if error
	 * 
	 * @return Integer value of Bowling score, in case of error return value is -1
	 */
	public int getScore() {
		// TODO: calculate the score of game and return correct value
		int score = 0;
		int frame = 0;
		if (this.expectedFormat) {
			try {
				for (int i = 0; i < 10; i++) {
					if (isValid(frame)) {
						if (isStrike(frame)) {
							score += 10 + strikeBonus(frame + 1);
							frame += 2;
						} else if (isSpare(frame)) {
							score += 10 + this.frames[frame + 2];
							frame += 2;
						} else {
							score += this.frames[frame] + this.frames[frame + 1];
							frame += 2;
						}
					} else {
						return -1;
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return -1;
			}
			return score;
		} else {
			return -1;
		}
	}

	private boolean isValid(int frame) {
		int firstThrow = this.frames[frame];
		int secondThrow = this.frames[frame + 1];
		return firstThrow + secondThrow <= 10;
	}

	private boolean isStrike(int frame) {
		return this.frames[frame] == 10 && this.frames[frame + 1] == 0;
	}

	private boolean isSpare(int frame) {
		return (this.frames[frame] + this.frames[frame + 1]) == 10;
	}

	private int strikeBonus(int frame) {
		if (isStrike(frame + 1)) {
			return 10 + this.frames[frame + 3];
		} else {
			return this.frames[frame + 1] + this.frames[frame + 2];
		}
	}

	private boolean isCorrect(String game) {
		String normalFrame = "(\\[(([0-9])|(10)),([0-9]|(10))\\]){10}";
		String lastIsStrike = "(\\[(([0-9])|(10)),([0-9]|(10))\\]){9}(\\[10,0\\])(\\[(([0-9])|(10)),(([0-9])|(10))\\])";
		String lastIsSpare = "(\\[(([0-9])|(10)),([0-9]|(10))\\]){9}(\\[([0-9]),(([0-9])|(10))\\])(\\[(([0-9])|(10))\\])";
		if ((game.matches(normalFrame) || game.matches(lastIsStrike) || game.matches(lastIsSpare))) {
			return true;
		} else {
			return false;
		}
	}

	private boolean lastFrameValid() {
		if (!isSpare(18) && this.frames.length > 20) {
			return false;
		} else {
			return true;
		}
	}

}
