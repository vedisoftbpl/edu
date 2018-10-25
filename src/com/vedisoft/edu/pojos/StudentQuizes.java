package com.vedisoft.edu.pojos;

import java.io.Serializable;

public class StudentQuizes implements Serializable {

	protected int stqzId;
	protected int qzId;
	protected int sessionId;
	protected int score;
	protected int attempts;

	public int getStqzId() {
		return stqzId;
	}

	public void setStqzId(int stqzId) {
		this.stqzId = stqzId;
	}

	public int getQzId() {
		return qzId;
	}

	public void setQzId(int qzId) {
		this.qzId = qzId;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public StudentQuizes(int stqzId, int qzId, int sessionId, int score, int attempts) {
		super();
		this.stqzId = stqzId;
		this.qzId = qzId;
		this.sessionId = sessionId;
		this.score = score;
		this.attempts = attempts;
	}

	public StudentQuizes(int qzId, int sessionId, int score, int attempts) {
		super();
		this.qzId = qzId;
		this.sessionId = sessionId;
		this.score = score;
		this.attempts = attempts;
	}

	public StudentQuizes() {
		super();
	}

	@Override
	public int hashCode() {
		return stqzId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentQuizes other = (StudentQuizes) obj;
		if (attempts != other.attempts)
			return false;
		if (qzId != other.qzId)
			return false;
		if (score != other.score)
			return false;
		if (sessionId != other.sessionId)
			return false;
		if (stqzId != other.stqzId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "studentQuizes [stqzId=" + stqzId + ", qzId=" + qzId + ", sessionId=" + sessionId + ", score=" + score
				+ ", attempts=" + attempts + "]";
	}

}
