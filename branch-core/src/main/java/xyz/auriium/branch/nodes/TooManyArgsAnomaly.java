/*
 *
 *  Branch
 *  Copyright © 2021 Aurium
 *
 *  Branch is free software: you can redistribute it and/or modify
 *  It under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 *  Branch is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with Branch. If not, see <https://www.gnu.org/licenses/>
 *  and navigate to version 3 of the GNU Affero General Public License.
 *
 */

package xyz.auriium.branch.nodes;

import xyz.auriium.branch.interfacing.exceptional.Anomaly;
import xyz.auriium.branch.interfacing.exceptional.AnomalyType;

public class TooManyArgsAnomaly implements Anomaly {

    private final int expectedArgs;
    private final int suppliedArgs;

    public TooManyArgsAnomaly(int expectedArgs, int suppliedArgs) {
        this.expectedArgs = expectedArgs;
        this.suppliedArgs = suppliedArgs;
    }

    public int getExpectedArgs() {
        return expectedArgs;
    }

    public int getSuppliedArgs() {
        return suppliedArgs;
    }

    @Override
    public AnomalyType type() {
        return AnomalyType.INVALID_SYNTAX;
    }
}
