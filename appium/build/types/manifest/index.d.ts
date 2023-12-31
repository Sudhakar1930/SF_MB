/**
 * See `README.md` for information on how to add a new version of the schema.
 * @module
 */
import * as ManifestV2 from './base';
import * as ManifestV3 from './v3';
import * as ManifestV4 from './v4';
export * from './v4';
export { ManifestV2, ManifestV3, ManifestV4 };
export interface ManifestDataVersions {
    2: ManifestV2.ManifestData;
    3: ManifestV3.ManifestData;
    4: ManifestV4.ManifestData;
}
/**
 * One of the known versions of the `extensions.yaml` schema.
 *
 * @privateRemarks You probably don't need to edit this.
 */
export type AnyManifestDataVersion = ManifestDataVersions[keyof ManifestDataVersions];
//# sourceMappingURL=index.d.ts.map