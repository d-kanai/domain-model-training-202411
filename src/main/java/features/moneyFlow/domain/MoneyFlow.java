package features.moneyFlow.domain;

import features.product.domain.Product;

import java.util.UUID;

public class MoneyFlow {

    public UUID id;
    public final UUID userId;
    private final int value;

    private MoneyFlow(UUID id, UUID userId, int value) {
        this.id = id;
        this.userId = userId;
        this.value = value;
    }

    public static MoneyFlow charge(UUID userId, int value) {
        if (value > 10000) throw new RuntimeException("1度に１万円までしかチャージできません");
        return new MoneyFlow(UUID.randomUUID(), userId, value);
    }

    public static MoneyFlow use(UUID loginUserId, Product product) {
        return new MoneyFlow(UUID.randomUUID(), loginUserId, -product.price);

    }

    public static MoneyFlow reconstruct(UUID id, UUID userId, int value) {
        return new MoneyFlow(id, userId, value);

    }

    public int value() {
        return this.value;
    }
}
