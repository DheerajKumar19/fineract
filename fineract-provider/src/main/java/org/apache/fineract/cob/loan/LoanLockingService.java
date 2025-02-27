/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.cob.loan;

import java.time.LocalDate;
import java.util.List;
import org.apache.fineract.cob.data.LoanCOBParameter;
import org.apache.fineract.cob.domain.LoanAccountLock;
import org.apache.fineract.cob.domain.LockOwner;

public interface LoanLockingService {

    void applySoftLock(LocalDate lastClosedBusinessDate, LoanCOBParameter loanCOBParameter, boolean isCatchUp);

    void upgradeLock(List<Long> accountsToLock, LockOwner lockOwner);

    void deleteByLoanIdInAndLockOwner(List<Long> loanIds, LockOwner lockOwner);

    List<LoanAccountLock> findAllByLoanIdIn(List<Long> loanIds);

    LoanAccountLock findByLoanIdAndLockOwner(Long loanId, LockOwner lockOwner);
}
