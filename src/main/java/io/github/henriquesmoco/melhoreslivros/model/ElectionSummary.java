package io.github.henriquesmoco.melhoreslivros.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ElectionSummary {
    private int electionId;
    private String subject;

    public ElectionSummary() {

    }

    public ElectionSummary(int electionId, String subject) {
        this.electionId = electionId;
        this.subject = subject;
    }

    public int getElectionId() {
        return electionId;
    }

    public void setElectionId(int electionId) {
        this.electionId = electionId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }
        ElectionSummary summary = (ElectionSummary) obj;
        return new EqualsBuilder()
                .append(this.electionId, summary.electionId)
                .append(this.subject, summary.subject)
                .isEquals();
    }

    @Override
    public int hashCode() {
        // you pick a hard-coded, randomly chosen, non-zero, odd number
        // ideally different for each class
        return new HashCodeBuilder(17, 37).
                append(electionId).
                append(subject).
                toHashCode();
    }

    @Override
    public String toString() {
        return String.format("ElectionSummary[ElectionId=%d, Subject=%s]", electionId, subject);
    }
}
