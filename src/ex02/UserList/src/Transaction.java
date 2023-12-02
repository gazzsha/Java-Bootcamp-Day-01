
import java.util.UUID;

enum typeTransfer {
    CREDIT,
    DEBIT
}

public class Transaction {
    private UUID id;
    private User Recipient;
    private User Sender;
    private typeTransfer typeTransfer;
    private long sumTransfer;
    public Transaction(UUID id, User Recipient, User Sender, typeTransfer typeTransfer, long sumTransfer) {
        this.id = id;
        this.Recipient = Recipient;
        this.Sender = Sender;
        this.typeTransfer = typeTransfer;
        switch (typeTransfer) {
            case CREDIT:
                if (sumTransfer < 0) this.sumTransfer = sumTransfer;
                break;
            case DEBIT:
                if (sumTransfer > 0) this.sumTransfer = sumTransfer;
                break;

        }
    }

    public UUID getId() {
        return id;
    }

    public User getRecipient() {
        return Recipient;
    }

    public User getSender() {
        return Sender;
    }

    public typeTransfer getTypeTransfer() {
        return typeTransfer;
    }

    public long getSumTransfer() {
        return sumTransfer;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setRecipient(User recipient) {
        Recipient = recipient;
    }

    public void setSender(User sender) {
        Sender = sender;
    }

    public void setTypeTransfer(typeTransfer typeTransfer) {
        this.typeTransfer = typeTransfer;
    }

    public void setSumTransfer(long sumTransfer) {
        switch (typeTransfer) {
            case CREDIT:
                if (sumTransfer < 0) this.sumTransfer = sumTransfer;
                break;
            case DEBIT:
                if (sumTransfer > 0) this.sumTransfer = sumTransfer;
                break;
        }
    }

    @Override
    public String toString() {
        return "Id: " + id.toString() + "\n" + Recipient.toString() + Sender.toString() + "Type Transfer: " + typeTransfer.toString() + "\n" + "Sum transfer: " + sumTransfer + "\n";
    }

}
