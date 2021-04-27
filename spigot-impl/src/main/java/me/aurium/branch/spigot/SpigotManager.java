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

package me.aurium.branch.spigot;

import me.aurium.branch.centralized.CentralizedManager;
import me.aurium.branch.centralized.CentralizedManagerBinder;
import me.aurium.branch.centralized.base.NodeBase;
import me.aurium.branch.centralized.typeadapter.ManagerAdapter;
import me.aurium.branch.centralized.base.NodeBaseBuilder;
import me.aurium.branch.fallback.strategies.OneBackStrategy;
import me.aurium.branch.interfacing.handlers.InterfacingHandler;
import me.aurium.branch.interfacing.handlers.MessageMap;
import me.aurium.branch.spigot.adapter.SenderAdapter;
import me.aurium.branch.spigot.message.SpigotMessageMap;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class SpigotManager implements CentralizedManager<CommandSender, JavaPlugin> {

    private final static SenderAdapter defaultAdapter = new SenderAdapter();

    private final InterfacingHandler<CommandSender> defaultInterfacing;
    private final Set<NodeBase<CommandSender>> senders = new HashSet<>();

    //fuck code in the constructor rules
    // (This can be easily fixed if you give a shit but i happen to not care - make a pr if you do!)

    public SpigotManager(MessageMap<CommandSender> defaultResponser) {
        this.defaultInterfacing = defaultResponser.make();
    }

    public SpigotManager() {
        this.defaultInterfacing = new SpigotMessageMap<>().make();
    }

    @Override
    public CentralizedManagerBinder getBinder(JavaPlugin platform) {
        return new SpigotManagerBinder(platform.getName(), platform.getServer().getCommandMap(), senders);
    }

    @Override
    public NodeBaseBuilder<CommandSender, CommandSender> newCommand() {
        return new NodeBaseBuilder<>(this, defaultAdapter, new OneBackStrategy<>(), new SpigotContextProvider<>(defaultInterfacing), defaultInterfacing);
    }

    @Override
    public <C extends CommandSender> NodeBaseBuilder<CommandSender, C> newCommand(ManagerAdapter<CommandSender, C> adapter) {
        return new NodeBaseBuilder<>(this,adapter, new OneBackStrategy<>(), new SpigotContextProvider<>(defaultInterfacing), defaultInterfacing);
    }

    @Override
    public void injectCommand(NodeBase<CommandSender> base) {
        senders.add(base);
    }

}
