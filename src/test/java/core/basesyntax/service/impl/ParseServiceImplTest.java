package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParseServiceImplTest {
    private static ParseService parseService;

    @BeforeClass
    public static void beforeClass() {
        parseService = new ParseServiceImpl();
    }

    @Test
    public void parseData_Ok() {
        final List<Transaction> expectedList = parseService.parse(List.of("type,fruit,quantity",
                "b,apple,100",
                "s,banana,100",
                "p,banana,13"));
        List<Transaction> actualList = new ArrayList<>();
        actualList.add(new Transaction("b", new Fruit("apple"), 100));
        actualList.add(new Transaction("s", new Fruit("banana"), 100));
        actualList.add(new Transaction("p", new Fruit("banana"), 13));
        assertEquals(expectedList, actualList);
    }
}