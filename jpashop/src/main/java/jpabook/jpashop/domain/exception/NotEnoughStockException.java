package jpabook.jpashop.domain.exception;

public class NotEnoughStockException extends RuntimeException {

//  control + o   오버라이드 단축키
    public NotEnoughStockException() {

    }

    public NotEnoughStockException(String message) {
        super(message);
    }

    public NotEnoughStockException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }


}
