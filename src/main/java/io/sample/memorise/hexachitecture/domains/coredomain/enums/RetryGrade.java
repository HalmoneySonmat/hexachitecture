package io.sample.memorise.hexachitecture.domains.coredomain.enums;

public enum RetryGrade {
    NORMAL(5), SLIGHT_ANGRY(10), ANGRY(15), VERY_ANGRY(20), EXTREMELY_ANGRY(25);

    private int retryCount;

    RetryGrade(int retryCount) {
        this.retryCount = retryCount;
    }

    public boolean isRetryable(int retryCount) {
        return this.retryCount > retryCount;
    }
}
