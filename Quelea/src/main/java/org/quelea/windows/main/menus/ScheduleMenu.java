/*
 * This file is part of Quelea, free projection software for churches.
 *
 *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.quelea.windows.main.menus;

import java.util.logging.Logger;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import org.quelea.services.languages.LabelGrabber;
import org.quelea.services.utils.LoggerUtils;
import org.quelea.services.utils.QueleaProperties;
import org.quelea.services.utils.ShortcutManager;
import org.quelea.services.utils.Utils;
import org.quelea.windows.main.MainPanel;
import org.quelea.windows.main.QueleaApp;
import org.quelea.windows.main.actionhandlers.AddDVDActionHandler;
import org.quelea.windows.main.actionhandlers.AddImageActionHandler;
import org.quelea.windows.main.actionhandlers.AddPdfActionHandler;
import org.quelea.windows.main.actionhandlers.AddPowerpointActionHandler;
import org.quelea.windows.main.actionhandlers.AddTimerActionHandler;
import org.quelea.windows.main.actionhandlers.AddVideoActionHandler;
import org.quelea.windows.main.actionhandlers.AddWebActionHandler;
import org.quelea.windows.main.actionhandlers.ExportPDFScheduleSongsActionHandler;
import org.quelea.windows.main.actionhandlers.ShowNoticesActionHandler;
import org.quelea.windows.main.schedule.ScheduleList;

/**
 * Quelea's schedule menu.
 * <p/>
 *
 * @author Michael
 */
public class ScheduleMenu extends Menu {

    private static final Logger LOGGER = LoggerUtils.getLogger();
    private final MenuItem addPowerpointItem;
    private final MenuItem addVideoItem;
    private final MenuItem addTimerItem;
    private final MenuItem addDVDItem;
    private final MenuItem addPDFItem;
    private final MenuItem addWebItem;
    private final MenuItem addImageItem;
    private final StackPane dvdImageStack;
    private final MenuItem manageNoticesItem;
    private final MenuItem exportScheduleItem;

    /**
     * Create the scheudle menu
     */
    public ScheduleMenu() {
        super(LabelGrabber.INSTANCE.getLabel("schedule.menu"));

        final MainPanel mainPanel = QueleaApp.get().getMainWindow().getMainPanel();
        final ScheduleList scheduleList = mainPanel.getSchedulePanel().getScheduleList();
        boolean darkTheme = QueleaProperties.get().getUseDarkTheme();

        addPowerpointItem = new MenuItem(LabelGrabber.INSTANCE.getLabel("add.presentation.button"));
        if (!Utils.isMac()) {
            addPowerpointItem.setGraphic(new ImageView(new Image(darkTheme ? "file:icons/powerpoint-light.png" : "file:icons/powerpoint.png", 20, 20, true, false)));
        }
        addPowerpointItem.setOnAction(new AddPowerpointActionHandler());
        getItems().add(addPowerpointItem);

        addVideoItem = new MenuItem(LabelGrabber.INSTANCE.getLabel("add.video.button"));
        if (!Utils.isMac()) {
            addVideoItem.setGraphic(new ImageView(new Image(darkTheme ? "file:icons/video file-light.png" : "file:icons/video file.png", 20, 20, true, false)));
        }
        addVideoItem.setOnAction(new AddVideoActionHandler());
        getItems().add(addVideoItem);

        addTimerItem = new MenuItem(LabelGrabber.INSTANCE.getLabel("add.timer.tooltip"), new ImageView(new Image(darkTheme ? "file:icons/timer-dark-light.png" : "file:icons/timer-dark.png", 16, 16, false, true)));
        addTimerItem.setOnAction(new AddTimerActionHandler());
        getItems().add(addTimerItem);

        addPDFItem = new MenuItem(LabelGrabber.INSTANCE.getLabel("add.pdf.tooltip"), new ImageView(new Image(darkTheme ? "file:icons/add_pdf-light.png" : "file:icons/add_pdf.png", 16, 16, false, true)));
        addPDFItem.setOnAction(new AddPdfActionHandler());
        getItems().add(addPDFItem);

        dvdImageStack = new StackPane();
        dvdImageStack.getChildren().add(new ImageView(new Image(darkTheme ? "file:icons/dvd-light.png" : "file:icons/dvd.png", 16, 16, false, true)));
        addDVDItem = new MenuItem(LabelGrabber.INSTANCE.getLabel("add.dvd.button"), dvdImageStack);
        addDVDItem.setOnAction(new AddDVDActionHandler());
        if (!Utils.isMac()) {
            getItems().add(addDVDItem);
        }

        addWebItem = new MenuItem(LabelGrabber.INSTANCE.getLabel("add.website"), new ImageView(new Image(darkTheme ? "file:icons/web-small-light.png" : "file:icons/web-small.png", 16, 16, false, true)));
        addWebItem.setOnAction(new AddWebActionHandler());
        getItems().add(addWebItem);

        addImageItem = new MenuItem(LabelGrabber.INSTANCE.getLabel("add.images.panel"), new ImageView(new Image(darkTheme ? "file:icons/image-light.png" : "file:icons/image.png", 16, 16, false, true)));
        addImageItem.setOnAction(new AddImageActionHandler());
        getItems().add(addImageItem);

        getItems().add(new SeparatorMenuItem());

        manageNoticesItem = new MenuItem(LabelGrabber.INSTANCE.getLabel("manage.notices.button"), new ImageView(new Image(darkTheme ? "file:icons/info-light.png" : "file:icons/info.png", 16, 16, false, true)));
        manageNoticesItem.setOnAction(new ShowNoticesActionHandler());
        manageNoticesItem.setAccelerator(ShortcutManager.getKeyCodeCombination(QueleaProperties.get().getNoticesKeys()));
        getItems().add(manageNoticesItem);

        exportScheduleItem = new MenuItem(LabelGrabber.INSTANCE.getLabel("export.schedule.songs.pdf.button"), new ImageView(new Image(darkTheme ? "file:icons/pdf-light.png" : "file:icons/pdf.png", 16, 16, false, true)));
        exportScheduleItem.setOnAction(new ExportPDFScheduleSongsActionHandler());
        getItems().add(exportScheduleItem);

    }
}
