package domain.actionmanager.api.entity;

import java.util.Date;

public interface Action {
    String getId();

    String getName();

    OperationType getOperationType();

    String getOwner();


}
