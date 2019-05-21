package com.plan.plan.repository.service_interface;

import com.plan.plan.model.AccountingRecord;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecordRepositoryPageAndSort extends PagingAndSortingRepository<AccountingRecord, Integer> {
}
