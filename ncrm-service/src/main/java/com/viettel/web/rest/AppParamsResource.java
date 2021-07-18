package com.viettel.web.rest;

import com.viettel.domain.AppParams;
import com.viettel.repository.AppParamsRepository;
import com.viettel.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Transactional
public class AppParamsResource {

    private final Logger log = LoggerFactory.getLogger(AppParamsResource.class);

    private static final String ENTITY_NAME = "appParams";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AppParamsRepository appParamsRepository;

    public AppParamsResource(AppParamsRepository appParamsRepository) {
        this.appParamsRepository = appParamsRepository;
    }

    /**
     * {@code POST  /app-params} : Create a new appParams.
     *
     * @param appParams the appParams to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new appParams, or with status {@code 400 (Bad Request)} if the appParams has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/app-params")
    public ResponseEntity<AppParams> createAppParams(@Valid @RequestBody AppParams appParams) throws URISyntaxException {
        log.debug("REST request to save AppParams : {}", appParams);
        if (appParams.getId() != null) {
            throw new BadRequestAlertException("A new appParams cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AppParams result = appParamsRepository.save(appParams);
        return ResponseEntity.created(new URI("/api/app-params/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /app-params} : Updates an existing appParams.
     *
     * @param appParams the appParams to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated appParams,
     * or with status {@code 400 (Bad Request)} if the appParams is not valid,
     * or with status {@code 500 (Internal Server Error)} if the appParams couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/app-params")
    public ResponseEntity<AppParams> updateAppParams(@Valid @RequestBody AppParams appParams) throws URISyntaxException {
        log.debug("REST request to update AppParams : {}", appParams);
        if (appParams.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AppParams result = appParamsRepository.save(appParams);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, appParams.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /app-params} : get all the appParams.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of appParams in body.
     */
    @GetMapping("/app-params")
    public List<AppParams> getAllAppParams() {
        log.debug("REST request to get all AppParams");
        return appParamsRepository.findAll();
    }

    /**
     * {@code GET  /app-params/:id} : get the "id" appParams.
     *
     * @param id the id of the appParams to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the appParams, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/app-params/{id}")
    public ResponseEntity<AppParams> getAppParams(@PathVariable Long id) {
        log.debug("REST request to get AppParams : {}", id);
        Optional<AppParams> appParams = appParamsRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(appParams);
    }

    /**
     * {@code DELETE  /app-params/:id} : delete the "id" appParams.
     *
     * @param id the id of the appParams to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/app-params/{id}")
    public ResponseEntity<Void> deleteAppParams(@PathVariable Long id) {
        log.debug("REST request to delete AppParams : {}", id);
        appParamsRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
