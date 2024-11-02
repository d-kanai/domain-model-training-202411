package features.moneyFlow;

import features.moneyFlows.domain.MoneyFlow;
import features.moneyFlows.domain.MoneyFlowRepository;

import java.util.UUID;

public class MoneyFlowDataBuilder {
    private int value = 1000;

    public MoneyFlow please() {
        UUID userId = UUID.fromString("aa");
        MoneyFlow moneyFlow = MoneyFlow.charge(userId, value);
        new MoneyFlowRepository().save(moneyFlow);
        return moneyFlow;
    }

    public MoneyFlowDataBuilder value(int value) {
        this.value = value;
        return this;
    }
}
