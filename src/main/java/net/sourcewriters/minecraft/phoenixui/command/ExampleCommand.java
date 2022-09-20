package net.sourcewriters.minecraft.phoenixui.command;

import me.lauriichan.laylib.command.Actor;
import me.lauriichan.laylib.command.annotation.Action;
import me.lauriichan.laylib.command.annotation.Command;
import me.lauriichan.laylib.command.annotation.Description;
import me.lauriichan.laylib.localization.Key;
import net.sourcewriters.minecraft.phoenixui.api.IPhoenixContext;
import net.sourcewriters.minecraft.phoenixui.api.IPhoenixUIApi;
import net.sourcewriters.minecraft.phoenixui.api.message.Component;
import net.sourcewriters.minecraft.phoenixui.api.message.ComponentBuilder;

@Command(name = "phoenixui", aliases = {
    "pui"
}, description = "command.description.phoenixui")
public class ExampleCommand {

    @Action("test api")
    @Description("command.description.phoenixui.test.api")
    public void testApi(IPhoenixUIApi api, Actor<?> actor) {
        api.getMessage("some.message.id").hoverText("another.message.id", Key.of("player", actor.getName())).send(actor);
    }

    @Action("test context")
    @Description("command.description.phoenixui.test.context")
    public void testContext(IPhoenixContext context, Actor<?> actor) {
        if (context == null) {
            // Context is null if actor is not player
            return;
        }
        IPhoenixUIApi api = context.getApi();
        ComponentBuilder.create()
            .add(api.getMessage("we.like.messages", Key.of("something", "SomeValue")))
            .add(Component.of(actor.getName()).clickSuggest("/msg {0}", actor.getName()))
        .send(actor);
    }

}
