package com.srini.avro;

import com.srini.avro.invoice.InvoiceGenerator;
import com.srini.avro.types.PosInvoice;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class Producer {

    private InvoiceGenerator invoiceGenerator = InvoiceGenerator.getInstance() ;
    private final KafkaTemplate<String, PosInvoice> kafkaTemplate ;

    public void send(){
        IntStream.rangeClosed(1,500)
                .mapToObj(i -> invoiceGenerator.getNextInvoice())
                .map(invoice -> new ProducerRecord<>("invoice-topic-1", invoice.getStoreID().toString(), invoice))
                .forEach(kafkaTemplate::send) ;

    }
}
